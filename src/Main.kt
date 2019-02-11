/**
 * Точка входа в приложение
 *
 * @author EY.Samarin
 */

fun main(args: Array<String>) {
    //Пример массива для алгоритма сортировки
    var intArrayTest = intArrayOf(5,2,4,6,1,3,2,6)
    print("[init]: [ ")
    intArrayTest.forEach{print("$it ")}
    println("]")
    //запуск
    sort(intArrayTest,0,intArrayTest.size-1)
    print("[fin ]: [ ")
    intArrayTest.forEach{print("$it ")}
    println("]")
}

/**
 * Функция быстрой сортировки массива элементов A
 */
fun sort(A: IntArray, p: Int, r: Int){
    if(p<r){
        var q = ((p+r)/2)

        q = merge(A,p,q,r)

        sort(A,p,q)
        sort(A,q+1,r)
    }
}

fun merge(A: IntArray, p: Int, pivot: Int, r: Int): Int{
    var start=p
    var end=r
    var q = pivot

    while (start < end) {
        //находим близжайший элемент с начала массива,
        //который будет больше нашего опорного элемента
        while (start < q && A[start] <= A[q]) {
            start++
        }
        //находимо близжайший с конца элемент,
        //который будет меньше нашего опорного элемента
        while (end > q && A[q] <= A[end]) {
            end--
        }
        //если в процессе прохода по массиву значения start и end не сошлись в середине
        //меняем местами элементы под текущими позициями
        if (start < end) {
            val temp = A[start]
            A[start] = A[end]
            A[end] = temp
            when {
                //в случае если справа или слева мы дошли до позиции опорного элемента
                //значит кол-во элементов не равно по обеим сторонам
                //и следует отодвинуть позицию опорного элемента
                start == q -> {
                    q = end
                }
                end == q -> {
                    q = start
                }
            }
        }
    }
    return q
}

