package pl.maro_projekt.maro_quiz.services;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.maro_projekt.maro_quiz.dto.CategoriesDto;
import pl.maro_projekt.maro_quiz.dto.QuestionsDto;
import pl.maro_projekt.maro_quiz.frontend.GameOptions;

import java.net.URI;
import java.util.List;

@Service
@Log
public class QuizDataService {

//    public void getQuizCategories() {
//        RestTemplate restTemplate = new RestTemplate();
//        CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
//        log.info("Quiz categories: " + result.getCategories());
//    }

public List<CategoriesDto.CategoryDto> getQuizCategories() {
    RestTemplate restTemplate = new RestTemplate();
    CategoriesDto result = restTemplate.getForObject("https://opentdb.com/api_category.php", CategoriesDto.class);
    log.info("Quiz categories: " + result.getCategories());
    return result.getCategories();
}


    public List<QuestionsDto.QuestionDto> getQuizQuestions(GameOptions gameOptions) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl("https://opentdb.com/api.php")
                .queryParam("amount", gameOptions.getNumberOfQuestions())
                .queryParam("category", gameOptions.getCategoryId())
                .queryParam("difficulty", gameOptions.getDifficulty().name().toLowerCase())
                .build().toUri();
        log.info("Quiz question retrieve URL: " + uri);

        QuestionsDto result = restTemplate.getForObject(uri, QuestionsDto.class);
        log.info("Quiz questions: " + result.getResults());
        return result.getResults();
    }


}
