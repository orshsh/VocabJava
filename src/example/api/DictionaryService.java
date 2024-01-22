package example.api;

import example.entity.Word;

import java.util.List;

/**
 * Интерфейс сервиса описывает операции, которые будет использовать пользователь при выборе пункта меню в консоле
 */
public interface DictionaryService {

    Word create(Word word);

    Word findByKey(String key);

    Word update(Word word);

    List<Word> getAll();

    void delete(Word word);

}
