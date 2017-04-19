package org.northwind.config;
import org.northwind.NorthwindApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.springlets.data.jpa.repository.support.DetachableJpaRepositoryImpl;

/**
 * = SpringDataJpaDetachableRepositoryConfiguration
 TODO Auto-generated class documentation
 *
 */
@Configuration
@EnableJpaRepositories(repositoryBaseClass = DetachableJpaRepositoryImpl.class, basePackageClasses = NorthwindApplication.class)
@EntityScan(basePackageClasses = NorthwindApplication.class)
public class SpringDataJpaDetachableRepositoryConfiguration {
}
