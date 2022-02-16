package com.example.jpamapids;

import com.example.jpamapids.controller.Utils;
import com.example.jpamapids.entity.Author;
import com.example.jpamapids.entity.Book;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final MeterRegistry meterRegistry;

    @Async
    @Transactional(readOnly = true)
    public Future<Optional<Author>> getAuthorById(AuthorRepository repository, Long id) {
        System.out.println("********find autho in: " + Thread.currentThread().getName());
        try {
            Thread.sleep(31_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utils.printHikariConnectionMetric(meterRegistry);
        return new AsyncResult<>(repository.findById(id));
    }

    @Async
    @Transactional(readOnly = true)
    public Future<Optional<Book>> getBookById(BookRepository repository, Long id) {
        System.out.println("*********get book in: " + Thread.currentThread().getName());
        try {
            Thread.sleep(31_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utils.printHikariConnectionMetric(meterRegistry);
        return new AsyncResult<>(repository.findById(id));
    }
}
