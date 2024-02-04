package com.pactera.dataserver.sequence;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 * Using database sequence to automatically generate string type ID
 *
 * @author Pactera WangShuai
 * @date 2020/07/09 15:58
 */
public class StringSequenceGenerator extends SequenceStyleGenerator {
    public static final String PREFIX_PARAM = "prefix";
    public static final String DEF_PREFIX_VALUE = "";
    public static final String LENGTH_PARAM = "length";
    public static final String STRATEGY_PREFIX = "auto:";
    private String prefix;
    private String length;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj)
            throws HibernateException {
        Serializable sequence = super.generate(session, obj);
        Long id = Long.parseLong(sequence.toString());
        String format = this.length == null ? "%1s%2d" : "%1s%2$0" + length + "d";
        String currentPrefix = determinePrefix();
        return String.format(format, currentPrefix, id).trim();

    }

    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        this.prefix = ConfigurationHelper.getString(PREFIX_PARAM, properties, DEF_PREFIX_VALUE);
        this.length = ConfigurationHelper.getString(LENGTH_PARAM, properties);
        super.configure(new LongType(), properties, serviceRegistry);
    }

    private String determinePrefix() {
        if (prefix.startsWith(STRATEGY_PREFIX)) {
            switch (GeneratePrefix.Strategy.valueOf(prefix.substring(STRATEGY_PREFIX.length()))) {
                case singleLetter:
                    return GeneratePrefix.singleLetter();
                default:
                    return DEF_PREFIX_VALUE;
            }
        } else {
            return prefix;
        }
    }
}
