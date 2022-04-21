package com.example.jpamapids;

import com.example.jpamapids.controller.Utils;
import com.example.jpamapids.entity.Projection;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ProjectionService {

    private final ProjectionRepository projectionRepository;

    private final MeterRegistry meterRegistry;

    private final ProjectionServiceHelper projectionServiceHelper;


    public void getAndUPdateId1And2() {
        projectionServiceHelper.getAndUpdateId1();
        projectionServiceHelper.getAndUpdateId2();
    }

    @Service
    @RequiredArgsConstructor
    public static class ProjectionServiceHelper {

        private final ProjectionRepository projectionRepository;

        private final MeterRegistry meterRegistry;

        @Transactional
        public void getAndUpdateId1() {
            System.out.println("connection pool when run in service");
            Utils.printHikariConnectionMetric(meterRegistry);
            Projection projection = projectionRepository.findById(1L).get();
            projection.setCol2(ThreadLocalRandom.current().nextInt(0, 1000) + "");
        }

        @Transactional
        public void getAndUpdateId2() {
            System.out.println("connection pool when run in service");
            Utils.printHikariConnectionMetric(meterRegistry);
            Projection projection = projectionRepository.findById(2L).get();
            projection.setCol2(ThreadLocalRandom.current().nextInt(0, 1000) + "");
        }
    }
}
