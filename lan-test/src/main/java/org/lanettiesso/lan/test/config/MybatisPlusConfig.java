package org.lanettiesso.lan.test.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.executor.MybatisBatchExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * @author lan
 * @date 2020/9/22
 */
@Configuration
public class MybatisPlusConfig implements MybatisPlusPropertiesCustomizer {

    @Override
    public void customize(MybatisPlusProperties properties) {
        MybatisConfiguration configuration = properties.getConfiguration();
        LanMybatisConfiguration mybatisConfiguration = new LanMybatisConfiguration();
        if (configuration != null) {
            BeanUtils.copyProperties(configuration, mybatisConfiguration);
        }
        properties.setConfiguration(mybatisConfiguration);
    }

    public static class LanMybatisConfiguration extends MybatisConfiguration {
        @Override
        public Executor newExecutor(Transaction transaction, ExecutorType executorType) {
            if (executorType == ExecutorType.BATCH) {
                return new LanBatchExecutor(this, transaction);
            }
            return super.newExecutor(transaction, executorType);
        }
    }

    @SuppressWarnings("deprecation")
    public static class LanBatchExecutor extends MybatisBatchExecutor {

        private final SimpleExecutor executor;

        protected LanBatchExecutor(org.apache.ibatis.session.Configuration configuration, Transaction transaction) {
            super(configuration, transaction);
            executor = new SimpleExecutor(configuration, transaction);
        }

        @Override
        public int doUpdate(MappedStatement ms, Object parameterObject) throws SQLException {
            System.out.println(ms.getId());
            return executor.doUpdate(ms, parameterObject);
        }
    }

}
