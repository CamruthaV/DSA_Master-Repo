class Solution {
    private final long p = 31;
    private final long mod = (int) 1e9 + 7;
    private long[] p_pow = new long[1001];

    void rollingHash(long[] rh, String txt) {
      for (int i = 0; i < txt.length(); ++i) {
        int c = txt.charAt(i) - 'a' + 1;
        rh[i + 1] = ((rh[i] * 31) % mod + c + mod) % mod;
      }
    }

    long hash(long[] RH, int i, int j) {
      return ((RH[j + 1] - RH[i] * p_pow[j - i + 1]) % mod + mod) % mod;
    }

    public int longestDecomposition(String text) {
      p_pow = new long[text.length() + 1];
      p_pow[0] = 1;
      for (int i = 1; i <= text.length(); ++i) {
        p_pow[i] = p_pow[i - 1] * p;
        p_pow[i] = (p_pow[i] + mod) % mod;
      }
      long[] RH = new long[text.length() + 1];
      rollingHash(RH, text);
      return decompose(text, 0, text.length() - 1, RH);
    }

    int decompose(String text, int lo, int hi, long[] RH) {
      if (lo == hi + 1) return 0;
      if (lo > hi) return -1;

      int ans = 1;

      for (int len = 1; len <= (hi - lo + 1) / 2; ++len) {
        long h1 = hash(RH, lo, lo + len - 1);
        long h2 = hash(RH, hi - len + 1, hi);
        if (h1 == h2) {
          int a = decompose(text, lo + len, hi - len, RH);
          if (a > -1) ans = Math.max(a + 2, ans);
        }
        if (ans != 1) return ans;
      }

      return ans;
    }
  }