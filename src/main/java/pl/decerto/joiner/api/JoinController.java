package pl.decerto.joiner.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.decerto.joiner.service.JoinService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/join")
public class JoinController {

    @Autowired
    private JoinService joinService;

    @PostMapping
    public List<Integer> join(Map<String, List<Integer>> listMap, JoinMethod joinMethod) {
        return joinService.join(listMap, joinMethod);
    }

    ;
}
