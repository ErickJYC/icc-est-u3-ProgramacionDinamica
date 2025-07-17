import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD {
    public long getFibonaci(long n) {
        return n <= 1L ? n : this.getFibonaci(n - 1L) + this.getFibonaci(n - 2L);
    }

    public long getFibonaciPD(long n) {
        Map<Long, Long> cache = new HashMap();
        return this.getFibonaciPDHelper(n, cache);
    }

    private long getFibonaciPDHelper(long n, Map<Long, Long> cache) {
        if (cache.containsKey(n)) {
            return (Long)cache.get(n);
        } else if (n <= 1L) {
            return n;
        } else {
            long resultado = this.getFibonaciPDHelper(n - 1L, cache) + this.getFibonaciPDHelper(n - 2L, cache);
            cache.put(n, resultado);
            return resultado;
        }
    }
}
