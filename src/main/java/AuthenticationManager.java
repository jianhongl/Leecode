/**
 * FileName: AuthenticationManager
 * Author:   Jianhongl
 * Date:     24/1/2022 10:56 pm
 * Description:
 * History:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lujianhong
 * @create 24/1/2022
 * @since 1.0.0
 */
public class AuthenticationManager {
    private int timeToLive;

    private List<Token> tokens;
    class Token {
        private String tokenId;

        private int validTime;

        public Token(String tokenId, int currentTime) {
            this.tokenId = tokenId;
            this.validTime = currentTime + timeToLive;
        }

        public String getTokenId() {
            return tokenId;
        }

        public void setTokenId(String tokenId) {
            this.tokenId = tokenId;
        }

        public int getValidTime() {
            return validTime;
        }

        public void setValidTime(int validTime) {
            this.validTime = validTime;
        }

        @Override
        public String toString() {
            return "Token{" +
                    "tokenId='" + tokenId + '\'' +
                    ", validTime=" + validTime +
                    '}';
        }
    }
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokens = new ArrayList<>();
    }

    public void generate(String tokenId, int currentTime) {
        Token genToken = new Token(tokenId, currentTime);
        tokens.add(genToken);
    }

    public void renew(String tokenId, int currentTime) {
        tokens = tokens.stream().peek(token -> renew(token, tokenId, currentTime)).collect(Collectors.toList());
    }

    public int countUnexpiredTokens(int currentTime) {
        return (int) tokens.stream().filter(token -> currentTime < token.getValidTime()).count();
    }

    private Token renew(Token token, String tokenId, int currentTime) {
        if (tokenId.equals(token.getTokenId()) && currentTime < token.getValidTime()) {
            token.setValidTime(currentTime + timeToLive);
        }
        return token;
    }

    public static void main(String[] args) {
        AuthenticationManager manager = new AuthenticationManager(13);
        manager.generate("fuzxq", 5);
        System.out.println(manager.tokens.toString());
        manager.generate("izmry", 7);
        System.out.println(manager.tokens.toString());
        manager.generate("ybiqb", 13);
        manager.generate("gm", 14);
        System.out.println(manager.countUnexpiredTokens(15));
        System.out.println(manager.countUnexpiredTokens(18));
        System.out.println(manager.countUnexpiredTokens(19));
        manager.renew("ybiqb", 21);
        System.out.println(manager.tokens.toString());
        System.out.println(manager.countUnexpiredTokens(23));
        System.out.println(manager.countUnexpiredTokens(25));
        System.out.println(manager.tokens.toString());
        System.out.println(manager.countUnexpiredTokens(26));
        System.out.println(manager.tokens.toString());
        manager.generate("aqdm", 28);
        System.out.println(manager.tokens.toString());
        System.out.println(manager.countUnexpiredTokens(29));
    }
}
