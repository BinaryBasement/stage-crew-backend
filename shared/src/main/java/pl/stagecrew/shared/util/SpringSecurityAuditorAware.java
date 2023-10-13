package pl.stagecrew.shared.util;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of(SecurityAuthenticationManager.getAuthenticationName());
    }
}
