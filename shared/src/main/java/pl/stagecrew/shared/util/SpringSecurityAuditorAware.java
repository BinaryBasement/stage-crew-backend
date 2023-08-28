package pl.stagecrew.shared.util;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import pl.stagecrew.shared.common.CommonConstants;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {

        if (SecurityAuthenticationManager.isAuthenticated()) {
            return Optional.of(SecurityAuthenticationManager.getAuthenticationName());
        }

        return Optional.of(CommonConstants.ANONYMOUS);
    }
}
