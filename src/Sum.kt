/**
 * @author Archi - простейший пример рекурсивного вызова функции для подсчета суммы элементов списка
 */
class Sum(){
    fun sum(list: List<Int>): Int {
        if(list.size==1) return list[0]
        else return list.first() + sum(list.drop(1))
    }
}