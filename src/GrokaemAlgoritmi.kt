/**
 * Здесь будут реализации базовых алгоритмов из книги Адитья Брахгава - грокаем алгоритмы
 */
class GrokaemAlgoritmi{
    init {
        //Пример массива для алгоритма сортировки
        val intArrayTest = intArrayOf(5,2,4,6,1,3,2,6)
        print("[init]: [ ")
        intArrayTest.forEach{print("$it ")}
        println("]")

        //запуск
        //quickSort(intArrayTest,0,intArrayTest.size-1)
        selectSort(intArrayTest)

        //вывод отсортированного массива
        print("[fin ]: [ ")
        intArrayTest.forEach{print("$it ")}
        println("]")
    }

    /**
     * Функция быстрой сортировки массива элементов A
     */
    fun quickSort(array: IntArray, p: Int, r: Int){
        if(p<r){
            var q = ((p+r)/2)

            q = merge(array,p,q,r)

            quickSort(array,p,q)
            quickSort(array,q+1,r)
        }
    }

    /**
     * Функция реализующая часть алгоритма быстрой сортировки
     */
    fun merge(array: IntArray, left: Int, pivot: Int, right: Int): Int{
        var start=left
        var end=right
        var current = pivot

        while (start < end) {
            //находим близжайший элемент с начала массива,
            //который будет больше нашего опорного элемента
            while (start < current && array[start] <= array[current]) {
                start++
            }
            //находимо близжайший с конца элемент,
            //который будет меньше нашего опорного элемента
            while (end > current && array[current] <= array[end]) {
                end--
            }
            //если в процессе прохода по массиву значения start и end не сошлись в середине
            //меняем местами элементы под текущими позициями
            if (start < end) {
                val temp = array[start]
                array[start] = array[end]
                array[end] = temp
                when {
                    //в случае если справа или слева мы дошли до позиции опорного элемента
                    //значит кол-во элементов не равно по обеим сторонам
                    //и следует отодвинуть позицию опорного элемента
                    start == current -> {
                        current = end
                    }
                    end == current -> {
                        current = start
                    }
                }
            }
        }
        return current
    }

    fun selectSort(array: IntArray){
        var left=0
        while(left< array.size){
            var minIndex = left
            var right=left+1
            while (right< array.size){
                if (array[right] < array[minIndex]) {
                    minIndex = right
                }
                right++
            }
            if (minIndex != left) {
                val temp = array[left]
                array[left] = array[minIndex]
                array[minIndex] = temp
            }
            left++
        }
    }
}