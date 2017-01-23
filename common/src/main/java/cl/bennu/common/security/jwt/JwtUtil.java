package cl.bennu.common.security.jwt;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

public class JwtUtil {

    public static CorsFilter getCorsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");

        corsConfiguration.addAllowedMethod(RequestMethod.GET.name());
        corsConfiguration.addAllowedMethod(RequestMethod.POST.name());
        corsConfiguration.addAllowedMethod(RequestMethod.DELETE.name());
        corsConfiguration.addAllowedMethod(RequestMethod.PUT.name());
        corsConfiguration.addAllowedMethod(RequestMethod.PATCH.name());

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
