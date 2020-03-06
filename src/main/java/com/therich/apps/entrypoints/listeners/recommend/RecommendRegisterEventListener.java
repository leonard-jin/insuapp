package com.therich.apps.entrypoints.listeners.recommend;

import com.therich.apps.usecase.recommend.RecommendRegisterUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by kh.jin on 2020. 3. 6.
 */
@Component
public class RecommendRegisterEventListener {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final RecommendRegisterUseCase useCase;

    public RecommendRegisterEventListener(RecommendRegisterUseCase useCase) {
        this.useCase = useCase;
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT, classes = RecommendRegisterUseCase.Command.class)
    public void handle(RecommendRegisterUseCase.Command command) {
        log.debug("[Event] recommend register. event {}", command);
        useCase.register(command);
    }
}
