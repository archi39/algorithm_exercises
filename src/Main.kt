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
        //считаем текущий элемент
        var q = ((p+r)/2)

        //искомая функция
        println("[merg]: $p , $q , $r")
        q = merge(A,p,q,r)

        //сортировка до элемента q
        print("[srt$q]: [ ")
        var i=p
        while (i<=q)
            print("${A[i++]} ")
        println("]")
        sort(A,p,q)

        //сортировка после элемента q
        print("[srt$r]: [ ")
        i=q+1
        while (i<=r)
            print("${A[i++]} ")
        println("]")
        sort(A,q+1,r)
    }
}

fun merge(intArray: IntArray, p: Int, pivot: Int, r: Int): Int{
    var start=p
    var end=r
    var q = pivot

    while (start < end) {
        while (start < q && intArray[start] <= intArray[q]) {
            start++
        }
        while (end > q && intArray[q] <= intArray[end]) {
            end--
        }
        if (start < end) {
            val temp = intArray[start]
            intArray[start] = intArray[end]
            intArray[end] = temp
            print("[step]: [ ")
            intArray.forEach{print("$it ")}
            println("]")
            when {
                start == q -> {
                    q = end
                    println("[cur ]: $q")
                }
                end == q -> {
                    q = start
                    println("[cur ]: $q")
                }
            }
        }
    }
    return q
}

