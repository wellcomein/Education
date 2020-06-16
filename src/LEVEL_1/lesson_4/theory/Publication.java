package LEVEL_1.lesson_4.theory;

// Полиморфизм
abstract class Publication {
    protected String title;

    public Publication(String title){
        this.title = title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    // Этот метод должен напечатать публикацию, но мы не знаем, как именно это сделать, и потому объявляем его абстрактным
    abstract public void render();
}

// Теперь можно перейти к созданию производных классов, которые и реализуют недостающую функциональность:
/*
class News extends Publication
{
    public void render(){
        System.out.println("Вывод на экран новости");
    }
}
class Announcement extends Publication {
    public void render(){
        cutText();
        System.out.println("Вывод на экран анонса");
    }

    private String cutText(){
        // Укорачивание текста для анонса
    }
}

// Теперь при использовании можно заменить конкретный класс его абстрактным родителем или интерфейсом:
    Publication[] publications = new Publication[2];

publication[0] = new News();
        publication[1] = new Announcement();

        for(Publication pub : publications){
        pub.render();
        }
*/