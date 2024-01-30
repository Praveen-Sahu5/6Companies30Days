public class first {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minimizeSet(int d1, int d2, int u1, int u2) {
        long lo = 1, hi = (int) 10e10;
        long ans = hi;
        long lcm = ((long) d1 * (long) d2) / gcd(d1, d2);
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            int x = (int) (mid - mid / d1);
            int y = (int) (mid - mid / d2);
            int z = (int) (mid - mid / lcm);
            if (x < u1 || y < u2 || z < u1 + u2) {
                lo = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                hi = mid - 1;
            }
        }
        return (int) ans;
    }

    public static void main(String args[]) {
        first solution = new first();
        int d1 = 2;
        int d2 = 7;
        int u1 = 1;
        int u2 = 3;

        int result = solution.minimizeSet(d1, d2, u1, u2);
        System.out.println(result);
    }
}
