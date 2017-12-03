package consign;

import java.lang.reflect.Method;

/**
 * Created by GuiRunning on 2017/12/1.
 */
public class Event {

    private Object object;
    private String methodName;
    private Class<?>[] paramTypes;
    private Object[] params;

    public Event() {
    }

    public Event(Object object, String methodName, Object[] params) {
        this.object = object;
        this.methodName = methodName;
        this.params = params;
        contractParamsType(params);
    }

    private void contractParamsType(Object[]  params){
        this.paramTypes=new Class[params.length];
        for(int i=0;i<params.length;i++){
            this.paramTypes[i]=params[i].getClass();
        }
    }

    public void invoke() throws Exception{
        Method method = this.object.getClass().getMethod(this.methodName, this.paramTypes);
        if(method==null)return;
        method.invoke(this.object,this.params);
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return this.params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
