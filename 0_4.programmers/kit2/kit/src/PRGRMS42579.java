import java.util.*;

public class PRGRMS42579 {
    public static void main(String[] args) {

    }
    static class Genre {
        String name;
        List<Music> musics;
        int totalCount;

        Genre(String name) {
            this.name = name;
            musics = new ArrayList<>();
            totalCount = 0;
        }

        public void addMusic(Music music) {
            musics.add(music);
            totalCount += music.count;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Music {
        int id;
        int count;

        Music(int id, int count) {
            this.id = id;
            this.count = count;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreMap = new HashMap<>();
        for (int i=0;i<genres.length;i++) {
            Music music = new Music(i, plays[i]);
            genreMap.putIfAbsent(genres[i], new Genre(genres[i]));
            Genre genre = genreMap.get(genres[i]);
            genre.addMusic(music);
        }

        List<Genre> genreList = new ArrayList<>(genreMap.values());

        genreList.sort((g1, g2) -> Integer.compare(g2.totalCount, g1.totalCount));

        List<Integer> answerList = new ArrayList<>();
        for (Genre genre : genreList) {
            List<Music> musics = genre.musics;
            musics.sort((m1, m2) -> {
                if (m1.count != m2.count) {
                    return Integer.compare(m2.count, m1.count);
                }
                return Integer.compare(m1.id, m2.id);
            });

            answerList.add(musics.get(0).id);
            if (musics.size() >= 2) {
                answerList.add(musics.get(1).id);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i=0;i < answer.length;i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
