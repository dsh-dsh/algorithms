package lesson3_sets;

public class WordsInSet {
    public static void main(String[] args) {
        String str = "Давно выяснено, что при оценке дизайна и композиции читаемый текст мешает " +
                "сосредоточиться. Lorem Ipsum используют потому, что тот обеспечивает более или менее " +
                "стандартное заполнение шаблона, а также реальное распределение букв и пробелов " +
                "в абзацах, которое не получается при простой дубликации Здесь ваш текст.. " +
                "Здесь ваш текст.. Здесь ваш текст.. Многие программы электронной вёрстки и " +
                "редакторы HTML используют Lorem Ipsum в качестве текста по умолчанию, так что " +
                "поиск по ключевым словам lorem ipsum сразу показывает, как много веб-страниц " +
                "всё ещё дожидаются своего настоящего рождения. За прошедшие годы текст Lorem Ipsum " +
                "получил много версий. Некоторые версии появились по ошибке, некоторые - намеренно " +
                "(например, юмористические варианты).";
        str = str.replaceAll("[.,]", "");
        Set<String> set = getSet(str);
        addMistakes(set);
        contains(set, "например используют Lorem Isum в качестве absent текса по умочанию");
    }

    static void contains(Set<String> set, String input) {
        String[] arr = input.split(" ");
        for(String str : arr) {
            if(set.contains(str)) System.out.println(str + " is in set");
        }
    }

    static Set<String> getSet(String input) {
        Set<String> set = new Set<>();
        for(String str : input.split(" ")) {
            set.add(str);
        }
        return set;
    }
    static void addMistakes(Set<String> set) {
        for(String str : set.getValues()) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                set.add(String.copyValueOf(chars, 0, i)
                        + String.copyValueOf(chars, i + 1, chars.length - (i + 1)));
            }
        }
    }
}
