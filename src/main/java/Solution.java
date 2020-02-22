import java.util.ArrayList;

class Solution {
    public static String rangeExtraction ( int[] arr ) {
        StringBuilder builder = new StringBuilder ( );

        ArrayList< Integer > queue = new ArrayList<> ( );

        int prev = -1;

        boolean first = true;

        for ( int i = 0 ; i < arr.length ; i++ ) {
            int val = arr[ i ];

            if ( first ) {
                builder.append ( val );
                first = false;
            } else if ( val - prev == 1 ) {
                queue.add ( val );
            } else {
                if ( queue.size ( ) == 1 ) {
                    builder.append ( "," );
                    builder.append ( prev );

                    queue.clear ( );
                } else if ( queue.size ( ) > 1 ) {
                    builder.append ( "-" );
                    builder.append ( prev );

                    queue.clear ( );
                }

                builder.append ( "," );
                builder.append ( val );
            }

            prev = val;
        }

        if ( queue.size ( ) == 1 ) {
            builder.append ( "," );
            builder.append ( prev );

            queue.clear ( );
        } else if ( queue.size ( ) > 1 ) {
            builder.append ( "-" );
            builder.append ( prev );

            queue.clear ( );
        }

        return builder.toString ( );
    }

    public static void main ( String[] args ) {
        System.out.println ( rangeExtraction ( new int[] {
            -6 , -3 , -2 , -1 , 0 , 1 , 3 , 4 , 5 , 7 , 8 , 9 , 10 , 11 , 14 , 15 , 17 , 18 , 19 , 20
        } ) );
    }
}