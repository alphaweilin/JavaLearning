package org.seckill.entity;

import java.util.Date;

public class SuccessKilled extends SuccessKilledKey {

	private short state;

    private Date createTime;
    
    private Seckill seckill;

    public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "SuccessKilled [seckillId=" + getSeckillId() + ", userPhone=" + getUserPhone() + ", state=" + state + ", createTime=" + createTime + ", seckill=" + seckill + "]";
	}
}