package com.itest.buildTest;

public class TestShepBean {
    private int testNumber;//用例步骤序号
    private String shepDescribe;//操作步骤的描述
    private String action;//动作
    private String positioningMethod;//定位方式
    private String webElementName;//定位元素
    private String dataTest;//数据
    
    public  TestShepBean(){
      
    }

    public int getTestNumber() {
      return testNumber;
    }

    public void setTestNumber(int testNumber) {
      this.testNumber = testNumber;
    }

    public String getShepDescribe() {
      return shepDescribe;
    }

    public void setShepDescribe(String shepDescribe) {
      this.shepDescribe = shepDescribe;
    }

    public String getAction() {
      return action;
    }

    public void setAction(String action) {
      this.action = action;
    }

    public String getPositioningMethod() {
      return positioningMethod;
    }

    public void setPositioningMethod(String positioningMethod) {
      this.positioningMethod = positioningMethod;
    }

    public String getWebElementName() {
      return webElementName;
    }

    public void setWebElementName(String webElementName) {
      this.webElementName = webElementName;
    }

    public String getDataTest() {
      return dataTest;
    }

    public void setDataTest(String dataTest) {
      this.dataTest = dataTest;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((action == null) ? 0 : action.hashCode());
      result = prime * result + ((dataTest == null) ? 0 : dataTest.hashCode());
      result = prime * result + ((positioningMethod == null) ? 0 : positioningMethod.hashCode());
      result = prime * result + ((shepDescribe == null) ? 0 : shepDescribe.hashCode());
      result = prime * result + testNumber;
      result = prime * result + ((webElementName == null) ? 0 : webElementName.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      TestShepBean other = (TestShepBean) obj;
      if (action == null) {
        if (other.action != null)
          return false;
      } else if (!action.equals(other.action))
        return false;
      if (dataTest == null) {
        if (other.dataTest != null)
          return false;
      } else if (!dataTest.equals(other.dataTest))
        return false;
      if (positioningMethod == null) {
        if (other.positioningMethod != null)
          return false;
      } else if (!positioningMethod.equals(other.positioningMethod))
        return false;
      if (shepDescribe == null) {
        if (other.shepDescribe != null)
          return false;
      } else if (!shepDescribe.equals(other.shepDescribe))
        return false;
      if (testNumber != other.testNumber)
        return false;
      if (webElementName == null) {
        if (other.webElementName != null)
          return false;
      } else if (!webElementName.equals(other.webElementName))
        return false;
      return true;
    }

    @Override
    public String toString() {
      return "TestShepBean [testNumber=" + testNumber + ", shepDescribe=" + shepDescribe
          + ", action=" + action + ", positioningMethod=" + positioningMethod + ", webElementName="
          + webElementName + ", dataTest=" + dataTest + "]";
    }

    
    

}
