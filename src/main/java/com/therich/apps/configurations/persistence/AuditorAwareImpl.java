package com.therich.apps.configurations.persistence;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Created by kh.jin on 2020. 2. 13.
 */
public class AuditorAwareImpl implements AuditorAware<Long> {
    private Long auditor = 10000L;

    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(auditor);
    }

    // todo : oauth or db 연동 작업
}
