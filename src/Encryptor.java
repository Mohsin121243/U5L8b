import java.util.ArrayList;

public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        int subString = 0;
      for(int i = 0; subString < str.length();i++){
          for(int j = 0; j < letterBlock[i].length;j++){
              if(subString<str.length()) {
                  letterBlock[i][j] = str.substring(subString, subString + 1);
                  subString++;
              }
          }
      }
      for(int n = 0; n < letterBlock.length;n++){
          for(int t = 0;t<letterBlock[n].length;t++){
              if(letterBlock[n][t]== null){
                  letterBlock[n][t] = "A";
              }
          }
      }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        ArrayList<String> code= new ArrayList<>();
        for(int i = 0; i < letterBlock.length;i++){
            for(int j = 0; j< letterBlock[i].length;j++){
                if(i!=0){
                    code.set(j,code.get(j)+letterBlock[i][j]);
                }
                else{code.add(letterBlock[i][j]);}
            }
        }
        String finalCode = "";
        for(int k = 0; k<code.size();k++){
            finalCode += code.get(k);
        }
        return finalCode;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    /*public String encryptMessage(String message)
    {

    }*/

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        String newMessage = "";
        for(int i = 0; i<encryptedMessage.length()-numRows-1;i++) {
            int temp = i;
            while (newMessage.length() < encryptedMessage.length() - (numRows - 1)) {
                newMessage += encryptedMessage.substring(i, i + 1) + encryptedMessage.substring(i + numRows - 1, i + numRows);
                i += numRows - 1;
            }
            i = temp;
        }
        return newMessage;
    }
}