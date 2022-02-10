package com.example.jpamapids;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    final ParentRepository parentRepository;

    final ChildRepository childRepository;

    @GetMapping("/create")
    public String createChild() throws InterruptedException {
        Parent p = new Parent();
        p.setTitle("title 1");
        Child c = Child.builder()
                .content("tu hu con")
                .parent(parentRepository.save(p))
                .build();

        childRepository.save(c);

        return "OK";
    }

    @GetMapping("/selectParentChild")
    public String selectParentChild(@RequestParam Long id) throws InterruptedException {
        Parent p = parentRepository.findById(id).get();
        System.out.println("*************************************");
        childRepository.findById(p.getId());
        return "OK";
    }

    @GetMapping("/selectChildParent")
    public String selectChildParent(@RequestParam Long id) throws InterruptedException {
        Child c = childRepository.findById(id).get();
        System.out.println("*************************************");
        parentRepository.findById(id);
        return "OK";
    }
}
