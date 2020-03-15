package io.jgoerner.querygenerator.questions.adapter.web;

import io.jgoerner.querygenerator.questions.application.port.in.AbbreviationToNameUseCase;
import io.jgoerner.querygenerator.questions.application.port.in.AnswerQueryCorrectUseCase;
import io.jgoerner.querygenerator.questions.application.port.in.AnswerQueryWrongUseCase;
import io.jgoerner.querygenerator.questions.application.port.in.NameToAbbreviationUseCase;
import io.jgoerner.querygenerator.questions.domain.Answer;
import io.jgoerner.querygenerator.questions.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WebController {

    private final AbbreviationToNameUseCase abbreviationToNameUseCase;
    private final NameToAbbreviationUseCase nameToAbbreviationUseCase;
    private final AnswerQueryWrongUseCase answerQueryWrongUseCase;
    private final AnswerQueryCorrectUseCase answerQueryCorrectUseCase;

    @GetMapping("questions/random")
    Question random(@RequestParam(value = "type", defaultValue = "all") String type){
        switch (type){
            case "a2n":
                return abbreviationToNameUseCase.askAbbreviationToNameQuery();
            case "n2a":
                return nameToAbbreviationUseCase.askNameToAbbreviationQuery();
            default:
                return null;
        }
    }

    @PostMapping("questions/{qid}/answer")
    Answer reply(@PathVariable String qid, @RequestParam("result") String result) {
        if(result.toLowerCase().equals("ok")) {
            return answerQueryCorrectUseCase.createCorrect(qid);
        } else {
            return answerQueryWrongUseCase.createWrong(qid);
        }
    }
}
