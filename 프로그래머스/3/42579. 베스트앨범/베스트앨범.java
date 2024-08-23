import java.util.*;
import java.util.stream.*;

class Solution {
    static final int LIMIT = 2;

    static class Song implements Comparable<Song> {
        int id;
        int playCount;

        public Song(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Song other) {
            if (this.playCount == other.playCount) {
                return this.id - other.id;
            }
            return other.playCount - this.playCount;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 음악별 플레이 횟수
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 앨범
        Map<String, PriorityQueue<Song>> songMap = new HashMap<>();

        // 장르 별 총 재생 횟수와 곡 정보를 맵에 저장
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            songMap.putIfAbsent(genres[i], new PriorityQueue<>());
            songMap.get(genres[i]).add(new Song(i, plays[i]));
        }

        // 총 재생 횟수를 기준으로 장르 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> answerList = new ArrayList<>();

        for (String genre : sortedGenres) {
            PriorityQueue<Song> pq = songMap.get(genre);
            int count = 0;

            while (!pq.isEmpty() && count < LIMIT) {
                answerList.add(pq.poll().id);
                count++;
            }
        }

        // 결과 리스트를 배열로 변환하여 반환
        return answerList.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}