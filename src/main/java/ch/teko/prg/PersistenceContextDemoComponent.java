package ch.teko.prg;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;
import java.util.Set;

@Component
public class PersistenceContextDemoComponent {

    @PersistenceContext
    private EntityManager entityManager;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void onStartup(){
        Set<EntityType<?>> registeredEntities = entityManager.getMetamodel().getEntities();
        if (registeredEntities.isEmpty()){
            System.out.println("No entities registered yet");
        }
        registeredEntities.forEach(this::log);

        // 3 mal einen random String persistieren
        entityManager.persist(new DemoEntity());
        entityManager.persist(new DemoEntity());
        entityManager.persist(new DemoEntity());
    }

    private void log(EntityType<?> entityType) {
        System.out.println(entityType.getName() + " is registered at persitence context");
    }
}
