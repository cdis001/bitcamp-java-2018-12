package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages="com.eomcs.lms")
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")
@EnableTransactionManagement
@MapperScan("com.eomcs.lms.dao")
public class AppConfig {

  @Autowired Environment env;
  
  @Bean
  public DataSource dataSource() {
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(env.getProperty("jdbc.driver"));
    ds.setUrl(env.getProperty("jdbc.url"));
    ds.setUsername(env.getProperty("jdbc.username"));
    ds.setPassword(env.getProperty("jdbc.password"));
    return ds;
  }
  
  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
  
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource,
      ApplicationContext appCtx) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    
    factoryBean.setDataSource(dataSource);
    
    factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    
    factoryBean.setMapperLocations(
        appCtx.getResources("classpath:/com/eomcs/lms/mapper/*.xml"));
    
    return factoryBean.getObject();
  }
  
  /*
  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer mapperconfig = new MapperScannerConfigurer();
    mapperconfig.setSqlSessionTemplateBeanName("sqlSessionFactory");
    mapperconfig.setBasePackage("com.eomcs.lms.dao");
    return mapperconfig;
  }
  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Bean
  public TransactionManager transactionManager(
      SqlSessionFactoryProxy sqlSessionFactoryProxy) {

    return new TransactionManager(sqlSessionFactoryProxy);
  }

  @Bean
  public BoardDao boardDao(SqlSessionTemplate sessionTemplate) throws Exception {
    return sessionTemplate.getMapper(BoardDao.class);
  }
  
  @Bean
  public MemberDao memberDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(memberDao.class);
  }
  
  @Bean
  public LessonDao lessonDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(lessonDao.class);
  }
  
  @Bean
  public PhotoBoardDao photoBoardDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(PhotoBoardDao.class);
  }
  
  @Bean
  public PhotoFileDao photoFileDao(SqlSessionTemplate sessionTemplate) {
    return sessionTemplate.getMapper(PhotoFileDao.class);
  }
  */
}
