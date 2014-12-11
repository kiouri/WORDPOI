package com.kiouri.anketas2;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.kiouri.Utils;

public class WPage7 {
	
	private XWPFDocument document;
	private QwestionReport qwestionReport; 
	private GsAdd gsAdd;
	private int version;
	
	public static boolean isRecommendationExists = false;
	
	private static List<String> recommends = new ArrayList<String>();	
	
	static {
	recommends.add("Сформулировать требования к SSO");
	recommends.add("Описать сценарии работы, которые должно автоматизировать разрабатываемое решение");
	recommends.add("Описать в пояснительной записке технические решения по реализации требований заявленных в ТЗ");
	recommends.add("Добавить в пояснительную записку раздел, описывающий связь конкретного требования ТЗ с описанием технического решения этого требования");
	recommends.add("В отчетной документации отсутствует описание архитектуры системы");
	recommends.add("Производить предварительное согласование архитектуры решения с архитекторами УТП до начала разработки");
	recommends.add("Описать архитектуру системы не соответствует требованиям УТП, указанным в разъяснении к заполнению шаблона описания архитектуры системы");
	recommends.add("Привести решение в соответствие с основными архитектурным принципам");
	recommends.add("Привести прикладную архитектуру в соответствие с концепцией целевой архитектуры");
	recommends.add("Выделить в архитектуре приложения, разработанного в решении презентационный слой, слой бизнес логики, слой хранения данных на уровне компонентов приложения");
	
	recommends.add("Реализовать логическую независимость слоев");
	recommends.add("Реализовать физическую независимость слоев");
	recommends.add("Использовать технологию для кэширования данных запросов и контента");
	recommends.add("Использовать технологию для кэширования справочников приложения");
	recommends.add("Обеспечить кластеризацию приложения средствами платформы размещения приложения без дополнительного программирования приложения.");
	recommends.add("Обеспечить возможность кластеризации приложения независимо на каждом слое");		
	recommends.add("Обеспесить выполненение требований предъявляемых к компонентам презентационного слоя приложения");
	recommends.add("Обеспесить выполненение требований предъявляемых к компонентам слоя бизнес логики приложения");
	recommends.add("Обеспесить выполненение требований к компонентам слоя хранения данных приложения");
	recommends.add("Реализовать в решении конструктор отчетов");

	recommends.add("Использовать промышленный конструктор отчетов");
	recommends.add("Выделит компонент, реализующий API к приложению");
	recommends.add("Предоставить описание API приложения с примерами для интеграции с ним");
	recommends.add("Выделить компонент, реализующий адаптер к ИТ ландшафту Москвы");
	recommends.add("Выделить компоненты, отдельно на презентационном и слое бизнес-логике, ответственные за административные функции системы");
	recommends.add("Использована для организации прав доступа ролевую модель на основе LDAP");
	recommends.add("Обеспечивть синхронизацию данных пользователя с центральным LDAP каталогом на основе СУДИР");
	recommends.add("Обеспечить в приложении поддержку SSO");
	recommends.add("Описать сценарии интеграции с внешними системами");
	recommends.add("Обеспечить реализацию интеграции в соответствии с требованиям УТП ДИТ");

	recommends.add("Согласовать модель данных решения с архитекторами УТП");
	recommends.add("Описать модель данных решения");
	recommends.add("Обеспечить синхронизацию справочников системы с мастер данными из сервера НСИ");
	recommends.add("Привести описание в ПЗ в соответствие с разработанным решением");
	recommends.add("Привести техническое решение в соответствие с целевой архитекрурой");
	recommends.add("Реализовать в техническом решении механизмы повышения качества и актуальности данных");
	recommends.add("Реализовать в техническом решении механизмы достоверности и  защиты данных");
	recommends.add("Изключить из технического решения дублирование данные, используемых в других решениях");
	recommends.add("Разработать и предоставить модель угроз, применительно к техническому решению");
	recommends.add("Разработать и предоставить описания механизмов защиты от угроз, применительно к техническому решению");
	
	recommends.add("Обеспечить ориентацию технического решения  на автоматизацию бизнес-процесса, а не отдельных функций");
	recommends.add("Обеспечить реализацию общедоступного API / сервисов для доступа к функциям приложения");
	recommends.add("Обеспечить повторное использование общедоступное API технического решения");
	recommends.add("Обеспечить соблюдение принципа слабой связанности при интеграции с другими системами");
	recommends.add("Обеспечить независимость технического решения от одного поставщика ПО (vendor lock-in)");
	recommends.add("Исключить хранение контента (файлов) технического решения из реляционной БД");
	recommends.add("Исключить из технического решения свою подсистему, реализующую транспортные функции");
	recommends.add("Не мспользовать одну и ту же реляционную БД для реализации операционной, транспортной и инфраструктурной функций");
	recommends.add("Разделить в архитектуре технического решения операционные и отчетные функции");
	recommends.add("Реализовать интеграционную архитектуру решения таким образом, что бы обеспечить изолированность от проблем, связанных с работоспособностью интегрируемых систем");

	recommends.add("Предусмотреть реализацию функции гарантированной доставки в интеграционной архитектуре");
	recommends.add("Предусмотреть в интеграционная архитектуре реализацию механизма претензионной работы");
	recommends.add("Архитектура приложений не предусматривает реализацию требовния по масштабированию решения ");
	recommends.add("Обеспечить в технической архитектуре решения реализацию требований по нагрузке");
	recommends.add("Обеспечить в технической архитектуре решения реализацию требований по доступности и  отказоустойчивости");
	recommends.add("Привести в ПЗ описание технической реализации интеграции с централизованной системой СУДИР");	
	}

	public WPage7(XWPFDocument document, QwestionReport qwestionReport, GsAdd gsAdd, int version){
		isRecommendationExists = false;
		this.document = document;
		this.qwestionReport = qwestionReport;
		this.gsAdd = gsAdd;
		this.version = version;
		p6();
	}
	
	private void p6() {
		List<String> significantRecommendations = getSignificantRecommendations();
		List<String> nonSignificantRecommendations = getNonSignificantRecomendations();
		if (significantRecommendations.size() > 0
				|| nonSignificantRecommendations.size() > 0) {

			isRecommendationExists = true;
			
			Utils.header0(document,
					"6 Предложения по повышению качества анализируемых технических решений");
			Utils.plain(document,
					"Для дальнейшего повышения качества технического решения "
							+ gsAdd.getSystemName() + " рекомендуется:");
			for (String recomendation : significantRecommendations) {
				Utils.plain(document, recomendation);
			}

			for (String recomendation : nonSignificantRecommendations) {
				Utils.plain(document, recomendation);
			}
		} else {
			Utils.plain(document, "Качество технического решения соответствует предъявляемым требованиям");
		}
	}
	
	private List<String> getSignificantRecommendations(){
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < qwestionReport.getQwestions().size() - 1; i++){
			if(qwestionReport.getQwestions().get(i).getEssentiality().equalsIgnoreCase("Да")){
				if (qwestionReport.getQwestions().get(i).getAnswer().equalsIgnoreCase("Нет")){
					result.add(recommends.get(i));
				}
			}			
		}
		return result;
	}
	
	private List<String> getNonSignificantRecomendations(){
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < qwestionReport.getQwestions().size() - 1; i++){
			if(qwestionReport.getQwestions().get(i).getEssentiality().equalsIgnoreCase("Нет")){
				if (qwestionReport.getQwestions().get(i).getAnswer().equalsIgnoreCase("Нет")){
					result.add(recommends.get(i));
				}
			}			
		}
		return result;
	}

}
