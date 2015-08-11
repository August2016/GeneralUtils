package com.github.wenzhu.uuid.arithmatic;

import com.github.wenzhu.uuid.SnCode;
import com.github.wenzhu.uuid.SnCodeDao;
import com.github.wenzhu.uuid.SnCodeFactory;

/**
 * description:Ĭ�ϵ�����ӿ�
 *
 * @author: jy.chen
 * @version: 1.0
 * @since: 2015/8/11 - 10:58
 */
public class DefaultArithmatic implements IArithmatic {
	private SnCodeDao dao = SnCodeFactory.generateSnCodeDao();

	/**
	 * ͨ��ҵ�����ͼ����sncode
	 *
	 * @param businessType ҵ������
	 * @param cacheNum     ��������
	 * @return
	 */
	@Override
	public String genSnCode(String businessType, int cacheNum) {
        // 1������businessType ȥ��ȡ��Ӧ�� snCode
        SnCode snCode = dao.getByBusinessType(businessType,"");
        int uuid = 0;
        // 2��һ�����ҵ���
        if (null != snCode) {
            uuid = updateBusinessTypeSnCode(snCode);
        }else {
            // 3���Ҳ���
            uuid = createBusinessTypeSnCode(businessType);
        }
        return "";
    }

    private int createBusinessTypeSnCode(String businessType) {
        // 3.1���Ǿ����� uuid=1�������һ���µ�����
        SnCode vo = new SnCode(1, businessType, "");
        // 3.2��Ȼ����µ�uuid �����ص����ݴ洢��
        dao.createUuid(vo);

        return 0;
    }

    private int updateBusinessTypeSnCode(SnCode snCode) {

        return 0;

    }
}
