package example.impl;

import example.api.DictionaryRepository;
import example.api.DictionaryService;
import example.api.WordValidator;
import example.entity.Word;

import java.util.List;

/**
 * В данном классе реализована логика словаря. Все "бизнес" процессы должны быть реализованы тут
 *
 * Обрати внимание, что все методы достаточно абстрактны и завязки на тип пока нет, надо будет добавить.
 * Посмотри паттерн "Стратегия" каждый тип словаря будет реализовывать свою логику в зависимости реализации
 *
 * по сути класс DictionaryServiceImpl можно переименовать как DictionaryLatinServiceImpl и сделать реализацию для латинского словаря
 */
public class DictionaryServiceImpl implements DictionaryService {

    private DictionaryRepository dictionaryRepository;
    private WordValidator validator;

    /**
     * После того как прочитаешь про паттерн "Стратегия" - добавь в конструктор нужные реализации для каждого типа словаря
     */
    public DictionaryServiceImpl(DictionaryRepository dictionaryRepository, WordValidator validator) {
        this.dictionaryRepository = dictionaryRepository;
        this.validator = validator;
    }

    @Override
    public Word create(Word word) {
        //todo add validation validator.validate(word);

        return dictionaryRepository.save(word);
        //todo process exception if need
    }

    @Override
    public Word update(Word word) {
        Word wordFromFile = findByKey(word.getWord());
        //todo process exception if need
        //todo update entity + validator.validate(word);
        return dictionaryRepository.save(wordFromFile);
    }

    @Override
    public Word findByKey(String key) {
        //todo check key - maybe null
        return dictionaryRepository.findByKey(key);
        //todo process exception if need
    }

    @Override
    public List<Word> getAll() {
        return dictionaryRepository.getAll();
        //todo process exception if need
    }

    @Override
    public void delete(Word word) {
        dictionaryRepository.delete(word);
        //todo process exception if need
    }

}
