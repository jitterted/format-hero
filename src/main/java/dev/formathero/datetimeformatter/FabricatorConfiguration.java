package dev.formathero.datetimeformatter;

import dev.formathero.datetimeformatter.adapter.out.caffeine.CaffeineFabricatorRepository;
import dev.formathero.datetimeformatter.adapter.out.humanreadable.ReadableIdGenerator;
import dev.formathero.datetimeformatter.application.FabricatorService;
import dev.formathero.datetimeformatter.application.port.FabricatorRepository;
import dev.formathero.datetimeformatter.application.port.IdGenerator;
import dev.formathero.datetimeformatter.domain.ZonedDateTimeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.util.List;

@Configuration
public class FabricatorConfiguration {

    private static final ZonedDateTime JAN_3_2022 = ZonedDateTimeFactory.zoneDateTimeUtc(2022, 1, 3);
    private static final ZonedDateTime OCT_9_2023 = ZonedDateTimeFactory.zoneDateTimeUtc(2023, 10, 9);
    private static final ZonedDateTime NOV_25_2024 = ZonedDateTimeFactory.zoneDateTimeUtc(2024, 11, 25);

    @Bean
    public FabricatorService fabricatorService() {
        FabricatorRepository fabricatorRepository = new CaffeineFabricatorRepository();
        return new FabricatorService(fabricatorRepository, List.of(
                JAN_3_2022,
                OCT_9_2023,
                NOV_25_2024
        ));
    }

    @Bean
    public IdGenerator idGenerator() {
        return new ReadableIdGenerator();
    }
}
