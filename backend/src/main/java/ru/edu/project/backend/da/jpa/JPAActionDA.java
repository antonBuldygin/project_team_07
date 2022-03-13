package ru.edu.project.backend.da.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.edu.project.backend.api.actiongroups.ActionInterface;
import ru.edu.project.backend.da.ActionDALayer;
import ru.edu.project.backend.da.jpa.converter.ActionMapper;
import ru.edu.project.backend.da.jpa.entity.ActionEntity;
import ru.edu.project.backend.da.jpa.repository.ActionEntityRepository;

import java.util.List;

@Service
@Profile("SPRING_DATA")
public class JPAActionDA implements ActionDALayer {

    /**
     * Зависимость на репозиторий.
     */
    @Autowired
    private ActionEntityRepository repository;

    /**
     * Зависимость на маппер.
     */
    @Autowired
    private ActionMapper mapper;

    /**
     * @inheritDoc
     */
    @Override
    public List<ActionInterface> findByRequest(final long requestId) {
        return mapper.map(repository.findAllByPkRequestId(requestId));
    }

    /**
     * @inheritDoc
     * @return
     */
    @Override
    public ActionInterface save(final long requestId, final ActionInterface action) {
        ActionEntity draft = mapper.map(action);

        draft.getPk().setRequestId(requestId);

        return mapper.map(repository.save(draft));
    }
}
