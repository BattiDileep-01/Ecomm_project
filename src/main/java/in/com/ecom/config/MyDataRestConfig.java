package in.com.ecom.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entitymanager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        exposeIdconfig(config);
    }

    public  void exposeIdconfig(RepositoryRestConfiguration config){
        Set<EntityType<?>> entities = entitymanager.getMetamodel().getEntities();

        ArrayList<Class> entityclass = new ArrayList<>();

        for(EntityType entitytype : entities){

            entityclass.add(entitytype.getJavaType());
        }
        Class[] domaintype = entityclass.toArray(new Class[0]);

        config.exposeIdsFor(domaintype);
    }
}
