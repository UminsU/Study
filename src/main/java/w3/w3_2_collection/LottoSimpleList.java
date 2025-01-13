package w3.w3_2_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoSimpleList {
    // 1. 숫자 범위 1~45 랜덤 추출기 생성
    // 추출기 자체에서 중복번호 나올 수 없게 처리해도 됨
    public static List<Integer> generateRandomNumbers(int count) {
        if (count > 45 || count < 1) {
            throw new IllegalArgumentException("count는 1 이상 45 이하의 값이어야 합니다.");
        }

        // 2. 6개의 숫자를 당첨번호로 저장할 수 있는 List<Integer> 생성
        // 중복 번호가 나올 경우 Pass 할 수 있는 로직 구현
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers.subList(0, count);
    }

    // 3. 6개의 숫자를 복권번호로 저장할 수 있는 List<Integer> 생성
    public static List<Integer> inputRandomNumbers(int count) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputArray = new ArrayList<>();
        while (inputArray.size() < count) {
            System.out.println("1~45 범위의 복권 번호를 입력해주세요.");
            int inputNum = scanner.nextInt();

            // 유효 범위 검사
            if (inputNum < 1 || inputNum > 45) {
                System.out.println("유효하지 않은 번호입니다. 1~45 사이의 숫자를 입력해주세요.");
                continue;
            }

            // 중복 번호가 나올 경우 Pass 할 수 있는 로직 구현
            if (inputArray.contains(inputNum)) {
                System.out.println("중복된 번호입니다. 다른 번호를 입력해주세요.");
                continue;
            }

            // 리스트에 추가
            inputArray.add(inputNum);
        }

        return inputArray;
    }

    // 4. 당첨번호와 복권번호를 비교할 수 있는 비교 메서드 구현
    // List 에서 순서가 달라도 비교할 수 있게 로직 구현
    public static int compareNumbers(List<Integer> winningNumbers, List<Integer> userNumbers) {
        int matchCount = 0;

        // 당첨 번호와 사용자 번호 비교
        for (int num : userNumbers) {
            if (winningNumbers.contains(num)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public static void main(String[] args) {
        // 랜덤으로 생성된 당첨 번호
        List<Integer> winningNumbers = generateRandomNumbers(6);

        // 사용자로부터 복권 번호 입력받기
        List<Integer> userNumbers = inputRandomNumbers(6);

        // 당첨 번호와 입력 번호 비교
        int matchCount = compareNumbers(winningNumbers, userNumbers);
        // 5. 결과 출력 (당첨번호 / 복권번호 / 당첨여부)
        if (matchCount == 6) {
            System.out.println("당첨번호 : " + winningNumbers + " / 복권번호 : " + userNumbers + " / 당첨여부 : 당첨!" );
        } else {
            System.out.println("당첨번호 : " + winningNumbers + " / 복권번호 : " + userNumbers + " / 당첨여부 : 실패!" );
        }

    }
    // 6. 당첨 될 때까지 뽑는 반복문 작성 (3~5번 수정)
    //    당첨 시에만 결과 출력하고, 출력문에 반복 횟수를 함께 출력


}
