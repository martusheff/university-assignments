import java.util.Vector;

// Reality: A stock exchange lists many companies. Each company is identified by a tickr symbol.

// Analysis: results in an analysis object model. (UML)

// Implementation:
public class ClassDiagrams {

    public class StockExchange {
        public Vector m_Company = new Vector();
    }
    public class Company {
        public int m_tickerSymbol;
        public Vector m_StockExchange = new Vector();
    }
}
