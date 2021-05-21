package core.initialData;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import service.InitialService;

@Component
@RequiredArgsConstructor
public class InitialData implements ApplicationRunner {

    private final InitialService initialService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initialService.createEmployeeRole();
        initialService.createAdminRole();
        initialService.createSuperUser();
    }
}
