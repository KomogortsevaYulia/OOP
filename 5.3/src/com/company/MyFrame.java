package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{

    private static JPanel PaneProcess=new JPanel();
    private static MyTableModel Mytable=new MyTableModel();
    private static JTable table=new JTable(Mytable);

    public MyFrame(){
        super("Транспорт");
        // создаем строку главного меню
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createSubmenuFind());
        menuBar.add(createSubmenuAdd());
        menuBar.add(createSubmenuDel());
        menuBar.add(createSubmenuChange());
        //////заполняем frame
        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650,400));
        PaneProcess.add(new JLabel("Приветствуем вас в нашей программе!") );
        PaneProcess.setMinimumSize(new Dimension(400,500));
        setMinimumSize(new Dimension(1200,500));
        this.setLayout(new BorderLayout());
        add(menuBar,BorderLayout.NORTH);
        add(scrollPane,BorderLayout.CENTER);
        add(PaneProcess,BorderLayout.WEST);
        scrollPane.setVisible(true);
        PaneProcess.setVisible(true);
        menuBar.setVisible(true);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible(true);
    }
    private JMenu createSubmenuAdd() {
        JMenu text = new JMenu("Добавить");
        text.setPreferredSize(new Dimension(100,50));
        JMenuItem AddCar = new JMenuItem("Машина");
        JMenuItem AddTrain = new JMenuItem("Поезд");
        JMenuItem AddExpress = new JMenuItem("Экспресс");
        AddCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaneProcess.removeAll();
                CreatePaneAddCar();
                PaneProcess.repaint();
                PaneProcess.revalidate();
            }
        });
        AddTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaneProcess.removeAll();
                CreatePaneAddTr();
                PaneProcess.repaint();
                PaneProcess.revalidate();
            }
        });
        AddExpress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaneProcess.removeAll();
                CreatePaneAddEx();
                PaneProcess.repaint();
                PaneProcess.revalidate();
            }
        });
        text.add(AddCar);
        text.add(AddTrain);
        text.add(AddExpress);
        return text;
    }
    private JMenu createSubmenuDel() {
        JMenu text = new JMenu("Удалить");
        text.setPreferredSize(new Dimension(100,50));
        // и несколько вложенных меню
        JMenuItem DelId = new JMenuItem("По № записи");
        JMenuItem Del = new JMenuItem("В таблице");
        DelId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaneProcess.removeAll();
                CreatePaneDeleteId();
                PaneProcess.repaint();
                PaneProcess.revalidate();
            }
        });
        Del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaneProcess.removeAll();
                CreatePaneDelete();
                PaneProcess.repaint();
                PaneProcess.revalidate();
            }
        });
        text.add(DelId);
        text.add(Del);
        return text;
    }
    private JMenu createSubmenuFind(){
        JMenu text = new JMenu("Найти");
        text.setPreferredSize(new Dimension(100,50));
        // и несколько вложенных меню
        JMenuItem FindId = new JMenuItem("По № записи");
        FindId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaneProcess.removeAll();
                CreatePaneFindId();
                PaneProcess.repaint();
                PaneProcess.revalidate();
            }
        });
        text.add(FindId);
        return text;
    }
    private JMenu createSubmenuChange(){
        JMenu text=new JMenu("Изменить");
        JMenuItem t=new JMenuItem("В таблице");
        text.setPreferredSize(new Dimension(100,50));
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaneProcess.removeAll();
                CreatePaneChange();
                PaneProcess.repaint();
                PaneProcess.revalidate();
            }
        });
        text.add(t);
        return text;
    }

    private static void CreatePaneChangeCar(){
        JPanel ChCar=new JPanel();
        Transport tr=Mytable.getValueAt(table.getSelectedRow());
        int id=tr.getId();
        ChCar.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        // По умолчанию натуральная высота, максимальная ширина
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;  // нулевая ячейка таблицы по вертикали
        constraints.gridy = 0;
        JPanel Pane1 = new JPanel(new GridLayout(4, 2));
        JComboBox model = new JComboBox(new String[]{"Audi", "BMW", "Ford", "Honda", " Hyundai", "Kia", "Lada(ВАЗ)", "Mazda", "Mercedes-Benz", "Mitsubishi", "Nissan", "Renault", "Skoda", "Toyota"});
        model.setSelectedItem(((CarTransport) tr).getModel());
        JTextField years = new JTextField();
        years.setText(String.valueOf(((CarTransport) tr).getYears()));
        JComboBox condition = new JComboBox(new String[]{"В пути", "В гараже", "Ремонт"});
        condition.setSelectedItem(tr.getCondition());
        JTextField speed = new JTextField();
        speed.setText(String.valueOf(tr.getSpeed()));
        Pane1.add(new JLabel("Модель:"));
        Pane1.add(model);
        Pane1.add(new JLabel("Год выпуска:"));
        Pane1.add(years);
        Pane1.add(new JLabel("Состояние:"));
        Pane1.add(condition);
        Pane1.add(new JLabel("Средняя скорость:"));
        Pane1.add(speed);
        ChCar.add(Pane1, constraints);
        JButton CHCAR = new JButton("Изменить");
        CHCAR.setAlignmentX(CENTER_ALIGNMENT);
        constraints.gridy = 1;
        CHCAR.setPreferredSize(new Dimension(100, 50));
        ChCar.add(CHCAR, constraints);
        PaneProcess.add(ChCar);
        CHCAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mytable.setValueAt(new CarTransport(String.valueOf(model.getSelectedItem()),Integer.valueOf(years.getText()),String.valueOf(condition.getSelectedItem()),Integer.valueOf(speed.getText())),id);
                PaneProcess.removeAll();
                CreatePaneChange();
                PaneProcess.repaint();
                PaneProcess.revalidate();
                years.setText("");
                speed.setText("");
            }
        });
    }
    private static void CreatePaneChangeTr(){
        JPanel ChTr=new JPanel();
        Transport tr=Mytable.getValueAt(table.getSelectedRow());
        int id=tr.getId();
        ChTr.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        // По умолчанию натуральная высота, максимальная ширина
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0.5;
        constraints.gridx   = 0  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy = 0;
        JPanel Pane1=new JPanel(new GridLayout(5,2));
        JTextField number=new JTextField();
        number.setText(String.valueOf(((TrainTransport) tr).getNumber()));
        JComboBox type=new JComboBox(new String[] {"Грузовой", "Пассажирский", "Почтовый"});
        type.setSelectedItem(((TrainTransport) tr).getType());
        JTextField count=new JTextField();
        count.setText(String.valueOf(((TrainTransport) tr).getCarriage()));
        JComboBox condition=new JComboBox(new String[] {"В пути", "В гараже", "Ремонт"});
        condition.setSelectedItem(tr.getCondition());
        JTextField speed=new JTextField();
        speed.setText(String.valueOf(tr.getSpeed()));
        Pane1.add(new JLabel("Номер поезда:"));Pane1.add(number);
        Pane1.add(new JLabel("Тип:"));Pane1.add(type);
        Pane1.add(new JLabel("Количество вагонов:"));Pane1.add(count);
        Pane1.add(new JLabel("Состояние:"));Pane1.add(condition);
        Pane1.add(new JLabel("Средняя скорость:"));Pane1.add(speed);
        ChTr.add(Pane1,constraints);
        JButton CHTR=new JButton("Изменить");
        CHTR.setAlignmentX(CENTER_ALIGNMENT);
        constraints.gridy=1;
        CHTR.setPreferredSize(new Dimension(200,50));
        ChTr.add(CHTR,constraints);
        PaneProcess.add(ChTr);
        CHTR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transport t=new TrainTransport(Integer.valueOf(number.getText()),String.valueOf(type.getSelectedItem()),Integer.valueOf(count.getText()),String.valueOf(condition.getSelectedItem()),Integer.valueOf(speed.getText()));
                Mytable.setValueAt(t,id);
                PaneProcess.removeAll();
                CreatePaneChange();
                PaneProcess.repaint();
                PaneProcess.revalidate();
                number.setText("");
                count.setText("");
                speed.setText("");
            }
        });
    }
    private static void CreatePaneChangeEx(){
        JPanel ChEx=new JPanel();
        Transport tr=Mytable.getValueAt(table.getSelectedRow());
        int id=tr.getId();
        ChEx.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        // По умолчанию натуральная высота, максимальная ширина
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0.5;
        constraints.gridx   = 0  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy = 0;
        JPanel Pane1=new JPanel(new GridLayout(5,2));
        JTextField number=new JTextField();
        number.setText(String.valueOf(((TrainTransport) tr).getNumber()));
        JComboBox type=new JComboBox(new String[] {"Грузовой", "Пассажирский", "Почтовый"});
        type.setSelectedItem(((TrainTransport) tr).getType());
        JTextField count=new JTextField();
        count.setText(String.valueOf(((TrainTransport) tr).getCarriage()));
        JComboBox condition=new JComboBox(new String[] {"В пути", "В гараже", "Ремонт"});
        condition.setSelectedItem(tr.getCondition());
        JTextField speed=new JTextField();
        speed.setText(String.valueOf(tr.getSpeed()));
        Pane1.add(new JLabel("Номер экспресса:"));Pane1.add(number);
        Pane1.add(new JLabel("Тип:"));Pane1.add(type);
        Pane1.add(new JLabel("Количество вагонов:"));Pane1.add(count);
        Pane1.add(new JLabel("Состояние:"));Pane1.add(condition);
        Pane1.add(new JLabel("Средняя скорость:"));Pane1.add(speed);
        ChEx.add(Pane1,constraints);
        JButton ADDEX=new JButton("Изменить");
        ADDEX.setAlignmentX(CENTER_ALIGNMENT);
        constraints.gridy=1;
        ADDEX.setPreferredSize(new Dimension(200,50));
        ChEx.add(ADDEX,constraints);
        PaneProcess.add(ChEx);
        ADDEX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mytable.setValueAt(new ExpressTrain(Integer.valueOf(number.getText()),String.valueOf(type.getSelectedItem()),Integer.valueOf(count.getText()),String.valueOf(condition.getSelectedItem()),Integer.valueOf(speed.getText())),id);
                PaneProcess.removeAll();
                CreatePaneChange();
                PaneProcess.repaint();
                PaneProcess.revalidate();
                number.setText("");
                count.setText("");
                speed.setText("");
            }
        });
    }
    private  static void CreatePaneChange(){
        JPanel PaneCh=new JPanel();
        PaneCh.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        // По умолчанию натуральная высота, максимальная ширина
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0.5;
        constraints.gridx   = 0  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy=0;
        JLabel t=new JLabel("Выберите справа в таблице запись ");
        PaneCh.add(t,constraints);
        constraints.gridy=1;
        JButton t1=new JButton("Изменить" );
        PaneCh.setPreferredSize(new Dimension(250,500));
        PaneCh.add(t1,constraints);
        PaneProcess.add(PaneCh);
        t1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=table.getSelectedRow();
                if (row==-1){
                    JOptionPane.showMessageDialog(PaneProcess,
                            " Вы ничего не выбрали",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }else {
                    PaneProcess.removeAll();
                    if(Mytable.getValueAt(table.getSelectedRow()) instanceof CarTransport){
                        CreatePaneChangeCar();
                    }else if(Mytable.getValueAt(table.getSelectedRow()) instanceof ExpressTrain){
                        CreatePaneChangeEx();
                    } else if(Mytable.getValueAt(table.getSelectedRow()) instanceof TrainTransport){
                        CreatePaneChangeTr();
                    }
                    PaneProcess.repaint();
                    PaneProcess.revalidate();
                }
            }
        });
    }

    private  static void CreatePaneDelete(){
        JPanel PaneDelete=new JPanel();
        PaneDelete.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.5;
        constraints.gridx   = 0  ;  // нулевая ячейка таблицы по вертикали
        constraints.gridy=0;
        JLabel t=new JLabel("Выберите запись в таблице справа");
        JButton DEL=new JButton("Удалить");
        DEL.setAlignmentX(CENTER_ALIGNMENT);
        PaneDelete.setPreferredSize(new Dimension(250,300));
        PaneDelete.add(t,constraints);
        constraints.gridy=1;
        PaneDelete.add(DEL,constraints);
        PaneDelete.repaint();
        PaneDelete.revalidate();
        DEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=table.getSelectedRow();
                if (row==-1){
                    JOptionPane.showMessageDialog(PaneProcess,
                            " Вы ничего не выбрали",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Mytable.DeleteValueAt(row);
            }
        });
        PaneProcess.add(PaneDelete);
    }
    private  static void CreatePaneDeleteId(){
        JPanel PaneDeleteID=new JPanel();
        PaneDeleteID.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.5;
        constraints.gridx   = 0  ;  // нулевая ячейка таблицы по вертикали
        JTextField id=new JTextField();
        id.setPreferredSize(new Dimension(150,50));
        JButton DELID=new JButton("Удалить");
        DELID.setPreferredSize(new Dimension(150,50));
        PaneDeleteID.setPreferredSize(new Dimension(250,300));
        DELID.setAlignmentX(CENTER_ALIGNMENT);
        constraints.gridy = 0;
        PaneDeleteID.add(new JLabel("Введите № записи:"),constraints);
        constraints.gridy = 1;
        PaneDeleteID.add(id,constraints);
        constraints.gridy = 2;
        PaneDeleteID.add(DELID,constraints);
        PaneDeleteID.repaint();
        PaneDeleteID.revalidate();
        PaneProcess.add(PaneDeleteID);
        DELID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (Integer.parseInt(id.getText())<Mytable.getRowCount() & Integer.parseInt(id.getText())>0){
                        Mytable.DeleteValueAt(Integer.parseInt(id.getText()));
                    }else {
                        JOptionPane.showMessageDialog(PaneProcess,
                                " Нет такой записи",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PaneDeleteID,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                id.setText("");
            }
        });
    }

    private static void CreatePaneAddCar(){
        JPanel PaneAddCar=new JPanel();
        PaneAddCar.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.5;
        constraints.gridx   = 0  ;
        constraints.gridy = 0;
        JPanel Pane1=new JPanel(new GridLayout(4,2));
        JComboBox model=new JComboBox(new String[] {"Audi", "BMW", "Ford", "Honda", " Hyundai", "Kia", "Lada(ВАЗ)", "Mazda", "Mercedes-Benz", "Mitsubishi", "Nissan", "Renault", "Skoda", "Toyota"});
        JTextField years=new JTextField();
        JComboBox condition=new JComboBox(new String[] {"В пути", "В гараже", "Ремонт"});
        JTextField speed=new JTextField();
        Pane1.add(new JLabel("Модель:"));Pane1.add(model);
        Pane1.add(new JLabel("Год выпуска:"));Pane1.add(years);
        Pane1.add(new JLabel("Состояние:"));Pane1.add(condition);
        Pane1.add(new JLabel("Средняя скорость:"));Pane1.add(speed);
        PaneAddCar.add(Pane1,constraints);
        JButton ADDCAR=new JButton("Добавить");
        ADDCAR.setAlignmentX(CENTER_ALIGNMENT);
        constraints.gridy=1;
        ADDCAR.setPreferredSize(new Dimension(200,50));
        PaneAddCar.add(ADDCAR,constraints);
        PaneProcess.add(PaneAddCar);
        ADDCAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer.parseInt(years.getText());
                    Integer.parseInt(speed.getText());
                    Transport t=new CarTransport(String.valueOf(model.getSelectedItem()),Integer.parseInt(years.getText()),String.valueOf(condition.getSelectedItem()),Integer.parseInt(speed.getText()));
                    Mytable.AddValueAt(t);
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PaneAddCar,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                years.setText("");
                speed.setText("");
            }
        });
    }
    private  static void CreatePaneAddTr(){
        JPanel PaneAddTrain=new JPanel();
        PaneAddTrain.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0.5;
        constraints.gridx   = 0  ;
        constraints.gridy = 0;
        JPanel Pane1=new JPanel(new GridLayout(5,2));
        JTextField number=new JTextField();
        JComboBox type=new JComboBox(new String[] {"Грузовой", "Пассажирский", "Почтовый"});
        JTextField count=new JTextField();
        JComboBox condition=new JComboBox(new String[] {"В пути", "В гараже", "Ремонт"});
        JTextField speed=new JTextField();
        Pane1.add(new JLabel("Номер поезда:"));Pane1.add(number);
        Pane1.add(new JLabel("Тип:"));Pane1.add(type);
        Pane1.add(new JLabel("Количество вагонов:"));Pane1.add(count);
        Pane1.add(new JLabel("Состояние:"));Pane1.add(condition);
        Pane1.add(new JLabel("Средняя скорость:"));Pane1.add(speed);
        PaneAddTrain.add(Pane1,constraints);
        JButton ADDTR=new JButton("Добавить");
        ADDTR.setAlignmentX(CENTER_ALIGNMENT);
        constraints.gridy=1;
        ADDTR.setPreferredSize(new Dimension(200,50));
        PaneAddTrain.add(ADDTR,constraints);
        PaneProcess.add(PaneAddTrain);
        ADDTR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer.parseInt(number.getText());
                    Integer.parseInt(count.getText());
                    Integer.parseInt(speed.getText());
                    Mytable.AddValueAt(new TrainTransport(Integer.valueOf(number.getText()),String.valueOf(type.getSelectedItem()),Integer.valueOf(count.getText()),String.valueOf(condition.getSelectedItem()),Integer.valueOf(speed.getText())));
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PaneAddTrain,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                number.setText("");
                count.setText("");
                speed.setText("");
            }
        });
    }
    private  static void CreatePaneAddEx(){
        JPanel PaneAddExp=new JPanel();
        PaneAddExp.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0.5;
        constraints.gridx   = 0  ;
        constraints.gridy = 0;
        JPanel Pane1=new JPanel(new GridLayout(5,2));
        JTextField number=new JTextField();
        JComboBox type=new JComboBox(new String[] {"Грузовой", "Пассажирский", "Почтовый"});
        JTextField count=new JTextField();
        JComboBox condition=new JComboBox(new String[] {"В пути", "В гараже", "Ремонт"});
        JTextField speed=new JTextField();
        Pane1.add(new JLabel("Номер экспресса:"));Pane1.add(number);
        Pane1.add(new JLabel("Тип:"));Pane1.add(type);
        Pane1.add(new JLabel("Количество вагонов:"));Pane1.add(count);
        Pane1.add(new JLabel("Состояние:"));Pane1.add(condition);
        Pane1.add(new JLabel("Средняя скорость:"));Pane1.add(speed);
        PaneAddExp.add(Pane1,constraints);
        JButton ADDEX=new JButton("Добавить");
        ADDEX.setAlignmentX(CENTER_ALIGNMENT);
        constraints.gridy=1;
        ADDEX.setPreferredSize(new Dimension(200,50));
        PaneAddExp.add(ADDEX,constraints);
        PaneProcess.add(PaneAddExp);
        ADDEX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer.parseInt(number.getText());
                    Integer.parseInt(count.getText());
                    Integer.parseInt(speed.getText());
                    Mytable.AddValueAt(new ExpressTrain(Integer.valueOf(number.getText()),String.valueOf(type.getSelectedItem()),Integer.valueOf(count.getText()),String.valueOf(condition.getSelectedItem()),Integer.valueOf(speed.getText())));
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PaneAddExp,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }
                number.setText("");
                count.setText("");
                speed.setText("");
            }
        });
    }

    private  static void CreatePaneFindId(){
        JPanel PaneFindID=new JPanel();
        PaneFindID.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        // По умолчанию натуральная высота, максимальная ширина
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0.5;
        constraints.gridx   = 0  ;  // нулевая ячейка таблицы по вертикали
        JTextField id=new JTextField();
        id.setPreferredSize(new Dimension(150,50));
        JButton FINDID=new JButton("Найти");
        FINDID.setPreferredSize(new Dimension(150,50));
        constraints.gridy = 0;
        PaneFindID.add(new JLabel("Введите № записи:"),constraints);
        constraints.gridy = 1;
        PaneFindID.add(id,constraints);
        constraints.gridy = 2;
        PaneFindID.add(FINDID,constraints);
        PaneFindID.repaint();
        PaneFindID.revalidate();
        PaneProcess.add(PaneFindID);
        FINDID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (Integer.parseInt(id.getText())<Mytable.getRowCount() & Integer.parseInt(id.getText())>=0){
                        CreateDialogFindId(Integer.parseInt(id.getText()));
                        id.setText("");
                    }else {
                        JOptionPane.showMessageDialog(PaneFindID,
                                " Нет такой записи",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PaneFindID,
                            " Можно вводить только целые числа",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
    private static void CreateDialogFindId(int id){
        FindTableModel table1=new FindTableModel(new TransportManager());
        if(table1.getRowCount()!=0){
            table1.DeleteValueAt(0);
        }
        table1.AddValueAt(Mytable.getValueAt(id));
        JDialog dialogFindId = new JDialog();
        dialogFindId.setLayout(new BorderLayout());
        dialogFindId.setModal(true);
        dialogFindId.setMinimumSize(new Dimension(720,100));
        dialogFindId.setMaximumSize(new Dimension(800,120));
        dialogFindId.setLocationRelativeTo(PaneProcess);
        dialogFindId.setTitle("Найденная запись:");
        JTable tableFind=new JTable(table1);
        dialogFindId.add((new JScrollPane(tableFind)),BorderLayout.CENTER);
        dialogFindId.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialogFindId.setVisible(true);
        dialogFindId.repaint();
        dialogFindId.revalidate();
    }
}
