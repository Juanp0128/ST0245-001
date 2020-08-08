 public static boolean SumaGrupo(int[] nums, int target) {
        return SumaGrupo(0, nums, target);
    }

    private static boolean SumaGrupo(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        return SumaGrupo(start + 1, nums, target - nums[start]) || SumaGrupo(start + 1, nums, target);

    }


    public static boolean existe(int[] nums, int target) {
        return existe(0, nums, target);
    }


    public static boolean existe(int start, int[] nums, int target) {
        if (target == 0)
            return true;
        else {
            boolean loLlevo = existe(start + 1, nums, target - nums[start]);
            boolean noLoLlevo = existe(start + 1, nums, target);
            boolean loLlevoONoLoLlevo = noLlevo || loLlevo;
            return loLlevoONoLoLlevo;
        }
    }


    public static void combinations(String s) {

        combinationsAux("", s);

    }


    private static void combinationsAux(String prefix, String s) {
        if (s.length() == 0) {

            System.out.println(prefix);

        } else {

            combinationsAux(prefix + s.charAt(0), s.substring(1));
            combinationsAux(prefix, s.substring(1));

        }

    }

}
