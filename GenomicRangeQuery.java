class Solution {

    int[] solution(String S, int[] P, int[] Q) {
        int[][] c = new int[S.length()][4];
        int[] r = new int[P.length];
        int[] x = new int[4];

        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case 'A':
                    x[0]++;
                    break;
                case 'C':
                    x[1]++;
                    break;
                case 'G':
                    x[2]++;
                    break;
                default:
                    x[3]++;
                    break;
            }

            System.arraycopy(x, 0, c[i], 0, x.length);
        }

        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < x.length; j++)
                x[j] = P[i] > 0 ? c[Q[i]][j] - c[P[i] - 1][j] : c[Q[i]][j];

            for (int j = 0; j < x.length; j++) {
                if (x[j] > 0) {
                    r[i] = j + 1;
                    break;
                }
            }
        }

        return r;
    }
}
