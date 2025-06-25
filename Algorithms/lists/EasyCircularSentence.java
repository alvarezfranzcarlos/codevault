public class EasyCircularSentence {

    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");

        lastLetter = words[words.length - 1].charAt(words[words.length - 1].length() - 1);
        firstLetter = words[0].charAt(0);

        if (lastLetter == firstLetter) {
            return true;
        }

        for (int i = 0; i < words.length; i++) {
            lastLetter = words[i].charAt(words[i].length() - 1);
            firstLetter = words[i + 1].charAt(0);

            if (lastLetter != firstLetter) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        EasyCircularSentence easyCircularSentence = new EasyCircularSentence();
        boolean response = easyCircularSentence.isCircularSentence("hbcda");
        System.out.println(response);
    }
}
