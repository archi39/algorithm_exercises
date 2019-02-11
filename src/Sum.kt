/**
 * @author Archi - простейший пример рекурсивного вызова функции для подсчета суммы элементов списка
 */
class Sum(){
    fun sum(list: List<Int>): Int {
        if(list.size==1) return list[0]
        else return list.first() + sum(list.drop(1))
    }

    /**
     * количесвто элементов в списке
     */
    fun countOfList(list: List<Any>): Int{
        if(list.size==1) return 1
        else return 1 + countOfList(list.drop(1))
    }
}