package marco.lang;

import marco.lang.MarcoModule;
import marco.lang.MarcoName;
import marco.lang.MarcoObject;
import marco.runtime.Cast;
import marco.runtime.Environment;
import marco.lang.error.ExportError;

import java.util.List;

public class MarcoMemberAccess extends MarcoObject {
    private List<MarcoName> names;

    public MarcoMemberAccess(List<MarcoName> names) {
        this.names = names;
    }

    @Override
    public MarcoObject __eval(Environment dynamic) {
        MarcoModule module = Cast.toModule(dynamic.getRuntime().eval(names.get(0), dynamic));

        MarcoObject result;
        MarcoName firstName = names.get(1);
        if (module.hasExport(firstName)) {
            result = module.getMember(firstName);
        } else {
            throw new ExportError(firstName.getFileName(), firstName.getStartLine(), firstName);
        }
        for (int i = 2; i < names.size(); i++) {
            MarcoModule next = Cast.toModule(result);
            MarcoName name = names.get(i);
            if (next.hasExport(name)) {
                result = next.getMember(name);
            } else {
                throw new ExportError(name.getFileName(), name.getStartLine(), name);
            }
        }
        return result;
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public String convertToString() {
        return null;
    }
}
