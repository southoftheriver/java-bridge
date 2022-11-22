package bridge;

import static bridge.Direction.D;
import static bridge.Direction.U;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        final int start = 3;
        final int end = 20;
        Validator.validateRangeOfInt(size, start, end);
        List<Direction> dir = List.of(D, U);

        return IntStream.range(0, size)
            .mapToObj(i -> dir.get(bridgeNumberGenerator.generate()))
            .map(Enum::toString)
            .collect(Collectors.toList());
    }
}
