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

            c[i][0] = x[0];
            c[i][1] = x[1];
            c[i][2] = x[2];
            c[i][3] = x[3];
        }

        for (int i = 0; i < r.length; i++) {
            x[0] = P[i] > 0 ? c[Q[i]][0] - c[P[i] - 1][0] : c[Q[i]][0];
            x[1] = P[i] > 0 ? c[Q[i]][1] - c[P[i] - 1][1] : c[Q[i]][1];
            x[2] = P[i] > 0 ? c[Q[i]][2] - c[P[i] - 1][2] : c[Q[i]][2];
            x[3] = P[i] > 0 ? c[Q[i]][3] - c[P[i] - 1][3] : c[Q[i]][3];

            if (x[0] > 0) r[i] = 1;
            else if (x[1] > 0) r[i] = 2;
            else if (x[2] > 0) r[i] = 3;
            else r[i] = 4;
        }

        return r;
    }
}
