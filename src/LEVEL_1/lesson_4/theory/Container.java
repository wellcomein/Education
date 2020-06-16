package LEVEL_1.lesson_4.theory;

// Класс Container рассчитывает объем грузового контейнера в порту:
class Container {
    protected int width;
    protected int height;
    protected int depth;

    public Container(int w, int h, int d){
        width = w;
        height = h;
        depth = d;
    }
}

//Появляется класс для работы с тяжелыми контейнерами, и в нем — параметр weight (вес). Для родительского класса конструктор уже описан. Так зачем дублировать код?
class SuperContainer extends Container {
    protected int weight;

    public SuperContainer(int w, int h, int d, int m){
        super(w, h, d);
        weight = m;
    }
}
