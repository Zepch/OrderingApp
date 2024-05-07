package fastfoodfinal;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/** this is class extending the ObjectOutputStream class, for throwing IOExceptions
 * 
 * @author FDAA Group 4
 * @version 2.0
 * @since 2023-04-21
 */
public class CustomObjectWriter  extends ObjectOutputStream
{
	/**
	 * Constructor that uses the superclass
	 * @param out
	 * @throws IOException
	 */
    public CustomObjectWriter (OutputStream out) throws IOException
    {
        super(out);
    }
}